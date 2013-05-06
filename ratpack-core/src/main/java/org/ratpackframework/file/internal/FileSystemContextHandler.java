package org.ratpackframework.file.internal;

import org.ratpackframework.http.Exchange;
import org.ratpackframework.http.Handler;
import org.ratpackframework.file.FileSystemContext;

import java.io.File;

public class FileSystemContextHandler implements Handler {

  private final File file;
  private final Handler delegate;
  private final boolean absolute;
  private final FileSystemContext absoluteContext;

  public FileSystemContextHandler(File file, Handler delegate) {
    this.file = file;
    this.delegate = delegate;
    this.absolute = file.isAbsolute();
    this.absoluteContext = new DefaultFileSystemContext(file.getAbsoluteFile());
  }

  @Override
  public void handle(Exchange exchange) {
    if (absolute) {
      exchange.nextWithContext(absoluteContext, delegate);
    } else {
      FileSystemContext parentContext = exchange.getContext().get(FileSystemContext.class);
      if (parentContext == null) {
        exchange.nextWithContext(absoluteContext, delegate);
      } else {
        exchange.nextWithContext(parentContext.context(file.getPath()), delegate);
      }
    }
  }
}
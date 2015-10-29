package org.agilar.csd.mocks;

public interface SendersServices {

  PrintersService PrinterServiceLocator();
  EmailsService EmailServiceLocator();
}

package org.agilar.csd.refactoring.trivia;

import java.io.IOException;
import java.io.OutputStream;

public class CheckSumStreamOutput extends OutputStream {

	long checksum = 0;
	@Override
	public void write(int b) throws IOException {
		checksum += b;
	}

	public long getCheckSum(){
		return checksum;
	}
}

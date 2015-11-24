package org.agilar.csd.refactoring.trivia;

import java.io.IOException;
import java.io.OutputStream;

public class CheckSumOutput extends OutputStream {

	private long checkSum = 0;
	
	@Override
	public void write(int b) throws IOException {
		checkSum += b;
	}

	public long getCheckSum(){
		return checkSum;
	}
}

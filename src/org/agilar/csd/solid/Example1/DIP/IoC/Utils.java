package org.agilar.csd.solid.Example1.DIP.IoC;

public  class Utils {
	    public static final String storageAccount ="agilarcsd";
	    public static final String storageKey ="wozZtmPCJc+qtQF6F1X0VHU1DIyxi8zy7gyN/Epe41g6OyfHGPrh6g/nk8nsQHF5wIG4pEJHZiS8n8IW0mx00w==";
	    public static boolean IsBlobstorageUrl(String str)
	    {
	       
	        return str.startsWith(String.format("https://%s.blob.core.windows.net/", storageAccount));
	    }
}

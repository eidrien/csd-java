package org.agilar.csd.doubles;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.agilar.csd.doubles.exceptions.NoCurrentSaleAvailable;
import org.agilar.csd.doubles.exceptions.NoCustomerAvailableToBuyException;
import org.junit.Before;
import org.junit.Test;

public class TPVTest {

	TPV tpv;
	Repository<String,Customer> customers;
	Repository<String,Product> products;
	Repository<String,Sale> historicalSales;
	Repository<String,Sale> openSales;
	InvoiceService invoiceService;
	NotificationService notificationService;
	
	
	@Before
	public void setUp(){
		
		//TODO: set mocks, stubs, dummies, fakes and spies...
		//customers = ....
		//products = ....
		//historicalSales = ....
		//openSales = ....
		//invoiceService = ....
		//nofificationService = .....
		
		tpv = new TPV(notificationService,invoiceService,historicalSales, openSales,customers,products);
	}
	
	@Test
	public void WhenAllSalesAreCloseTotalOpenSalesMustBeZero() throws NoCustomerAvailableToBuyException, NoCurrentSaleAvailable {
		
//		tpv.forCustomer("Joan")
//			.buys()
//			.product("Banana", 2)
//			.product("Apples", 4)
//			.total()
//			.invoice();
//		
//		tpv.forCustomer("Manel")
//			.buys()
//			.product("Cherries", 2)
//			.product("Potatoes", 4)
//			.total()
//			.invoice()
//			.sendInvoice();
		
//		assertEquals("When all sales are closed, open sales must to be zero",tpv.printOpenSalesTotal(), "0.00€");
	
		assertTrue(true);
	}
	
//	@Test
//	public void WhenUsingMockitoToMockAllTheErrors(){
//		Sale sale = mock(Sale.class);
//		when(sale.getInvoiceIdentifier()).thenReturn("Test");
//		Customer customer = mock(Customer.class);
//		when(customer.getIdentifier()).thenReturn("Joan");
//		assertEquals(customer.getIdentifier(),"Joan");		
//	}
}

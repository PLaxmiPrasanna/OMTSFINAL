package com.cg.omts.testing;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IUserService;
import com.cg.omts.service.UserServiceImpl;
import static com.cg.omts.dto.Ticket.TicketStatus;

public class UserModuleTesting {

	IUserService userService = new UserServiceImpl();
	
	@Test
	public void getMovieDetailsTest() throws OMTSException {
		try {
			Movie actualMovie = userService.getMovieDetails(1);
			assertNotNull(actualMovie);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void generateTicketTest() throws OMTSException {
		try {
			Ticket ticket = new Ticket(1, 2, TicketStatus.BOOKED, 1, 1, 1, 1);
			int isGenerated = userService.generateTicket(1, ticket); 
			assertTrue(isGenerated > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void allocateSeatTest() throws OMTSException {
		try {
			int screenId = 1;
			List<Integer> selectedSeatsList = new ArrayList<Integer>();
			selectedSeatsList.add(1);
			selectedSeatsList.add(2);
			selectedSeatsList.add(3);
			selectedSeatsList.add(4);
			
			int isAllocated = userService.allocateSeat(selectedSeatsList, screenId);
			assertTrue(isAllocated > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void assignSeatsToTicketsTest() throws OMTSException {
		try {
			int ticketId = 1;
			List<Integer> seatsList = new ArrayList<Integer>();
			seatsList.add(1);
			seatsList.add(2);
			seatsList.add(3);
			seatsList.add(4);
			
			int isAssigned = userService.assignSeatsToTickets(ticketId, seatsList);
			assertTrue(isAssigned > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	

	
	@Test
	public void  getSeatsByTicketTest() throws OMTSException {
		try {
			int ticketId = 1;
			List<Integer> expectedSeatsList = new ArrayList<Integer>();
			expectedSeatsList.add(1);
			expectedSeatsList.add(2);
			expectedSeatsList.add(3);
			expectedSeatsList.add(4);
			
			List<Integer> actualSeatsList = userService.getSeatsByTicket(ticketId);
			assertEquals(expectedSeatsList, actualSeatsList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	
	
	@Test
	public void getTransactionDetailsTest() throws OMTSException {
		try {
			int ticketId = 1;
			//Transaction actualTransaction = new Transaction(1, 123456, 900);
			
			Transaction expectedTransaction = userService.getTransactionDetails(ticketId);
			assertNotNull(expectedTransaction);
			
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void deleteBookingDetailsTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isDeleted = userService.deleteBookingDetails(ticketId);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}	
	
	@Test
	public void deleteTransactionTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isDeleted = userService.deleteTransaction(ticketId);
			System.out.println(isDeleted);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void deleteAllocatedSeatsTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isDeleted = userService.deleteAllocatedSeats(ticketId);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void deleteSeatDetailsTest() throws OMTSException {
		try {
			int ticketId = 1;
			List<Integer> seatsList = new ArrayList<Integer>();
			seatsList.add(1);
			seatsList.add(2);
			seatsList.add(3);
			seatsList.add(4);
			
			int isDeleted = userService.deleteSeatDetails(seatsList);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void cancelTicketTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isCancelled = userService.cancelTicket(ticketId);
			assertTrue(isCancelled > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getCurrentBalanceTest() throws OMTSException {
		try {
			Transaction transaction = new Transaction(1, 123456, 900);
						
			int currentBalance = userService.getCurrentBalance(transaction);
			assertTrue(currentBalance > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void refundAfterCancellationTest() throws OMTSException {
		try {
			Transaction transaction = new Transaction(1, 123456, 900);
			int currentBalance = 24600;
			int isCancelled = userService.refundAfterCancellation(transaction, currentBalance);
			assertTrue(isCancelled > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getTheatresByMovieTest() {
		
	}
	
	@Test
	public void getTheatreNamesTest() {
		
	}
	
	
}

package org.escalade.consumer.contract.dao;

import java.util.List;

import org.escalade.model.beans.Reservation;
import org.escalade.model.beans.User;

public interface ReservationDao {
	void createResa(Reservation pResa);
	void setProcessed(Reservation pResa);
	Reservation getResaById(int pId);
	List<Reservation> getReservationByUser(User pUser);	
}

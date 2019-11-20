package org.escalade.business.contract.manager;

import java.util.List;

import org.escalade.model.beans.Reservation;
import org.escalade.model.beans.Topo;
import org.escalade.model.beans.User;
import org.escalade.model.exception.NotFoundException;

public interface ReservationManager {
	void createResa(Reservation pResa, Topo pTopo, User pUser);
	void setProcessed(Reservation pResa);
	Reservation getReservationById(int pId) throws NotFoundException;
	List<Reservation> getReservationByUser(User pUser);
}

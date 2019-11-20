package org.escalade.business.impl.manager;

import java.util.List;

import org.escalade.business.contract.manager.ReservationManager;
import org.escalade.model.beans.Reservation;
import org.escalade.model.beans.Topo;
import org.escalade.model.beans.User;
import org.escalade.model.exception.NotFoundException;

public class ReservationManagerImpl extends AbstractManager implements ReservationManager {
	@Override
	public void createResa(Reservation pResa, Topo pTopo, User pUser) {
		pResa.setTopo(pTopo);
    	pResa.setUserDemandeur(pUser);
    	pResa.setProcessed(false);
    	
		getDaoFactory().getReservationDao().createResa(pResa);
	}
	
	@Override
	public void setProcessed(Reservation pResa) {
		getDaoFactory().getReservationDao().setProcessed(pResa);
	}
	
	@Override
	public Reservation getReservationById(int pId) throws NotFoundException {
		if (pId < 1L) {
			throw new NotFoundException("Réservation non trouvée : numero = " + pId);
		} else {
			return getDaoFactory().getReservationDao().getResaById(pId);
		}	
	}
	
	@Override
	public List<Reservation> getReservationByUser(User pUser) {
		return getDaoFactory().getReservationDao().getReservationByUser(pUser);
	}
}

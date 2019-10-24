package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.ReservationManager;
import org.escalade.model.beans.Reservation;

public class ReservationManagerImpl extends AbstractManager implements ReservationManager {
	@Override
	public void createResa(Reservation pResa) {
		getDaoFactory().getReservationDao().createResa(pResa);
	}
}

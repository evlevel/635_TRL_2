import java.util.ArrayList;

/*
 
	1. Worker starts new transaction.
		public boolean startInTransaction()
		
	2. Worker enters Patron ID and SuD displays Patron info.
		public Patron enterPatronID (patronID)
		
	3. Worker enters Copy ID and SuD displays Copy info.
		public Copy enterCopyGoingIn (copyID)
		
		Repeat 3 for all copies
		
	4. Worker oks transaction and SuD checks in all entered Copies.
		public void endInTransaction()

 */
public class InController
{
	// private PatronStore pStore;
	// private CopyStore cStore;

	private Patron patron;
	private ArrayList<Copy> beingReturned;

	public InController(PatronStore ps, CopyStore cs)
	{
		// this.pStore = ps;
		// this.cStore = cs;
		beingReturned = new ArrayList<>();
	}

	// 1. Worker starts new transaction.
	public boolean startInTransaction()
	{
		this.beingReturned.clear();

		return true;
	}

	// 2. Worker enters Patron ID and SuD displays Patron info.
	public Patron enterPatronForCheckIn(String patronID)
	{
		this.patron = Stores.fetchPatron(patronID); // was
													// this.pStore.fetchPatron()
		return this.patron;
	}

	// 3. Worker enters Copy ID and SuD displays Copy info.

	public Copy enterCopyGoingIn(String copyID)
	{
		Copy c = Stores.fetchCopy(copyID);

		this.beingReturned.add(c);

		return c;
	}

	// Repeat 3 for all copies

	// 4. Worker oks transaction and SuD checks in all entered Copies.

	public void endInTransaction()
	{
		for (Copy c: beingReturned)
		{
			patron.checkCopyIn(c);
		}
		return;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	}
}

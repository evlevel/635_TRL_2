public class TRLApp
{
	private static CopyStore cStore;
	private static PatronStore pStore;
	private static OutController outController;
	private static InController inController;

	public static void main(String[] args)
	{
		cStore = new CopyStore();
		pStore = new PatronStore();

		outController = new OutController(pStore, cStore);
		inController = new InController(pStore, cStore);

		StdOut.println("Welcome to TRLApp.");

		boolean quitting = false;

		while (!quitting)
		{
			printMenu();
			String cmd = getCommand();

			switch (cmd)
			{
			case "1":
				doCheckOut();
				break;
			case "2":
				doCheckIn();
				break;
			case "3":
				doDisplayPatronInfo();
				break;
			case "0":
				StdOut.println("exiting...");
				quitting = true;
				break;
			}
		}
	}

	private static void doCheckOut()
	{
		StdOut.println("Checking copies out...");
		StdOut.println("Enter Patron ID:");
		String pid = StdIn.readString();
		StdOut.println("You entered: " + pid);

		boolean result = outController.startOutTransaction(); // pStore.fetchPatron(pid);

		Patron p = outController.enterPatronForCheckOut(pid);

		StdOut.println("Checking out copies to patron: " + p);

		while (true)
		{
			String copyID = getCopyID();

			if (copyID.equals("0"))
				break;

			Copy c = null;

			if (copyID != null)
			{
				c = outController.enterCopyGoingOut(copyID);
				StdOut.println("Checking out copy: ");
				StdOut.println(c);
			}
			else
				StdOut.println("Bad copy: reenter:");

		}

		outController.endOutTransaction();

		StdOut.println("End of doCheckOut()");
	}

	private static String getCopyID()
	{
		StdOut.println("Enter copyID to check out, 0 to finish:");
		String copyID = StdIn.readString();
		return copyID;
	}

	private static void doCheckIn()
	{
		StdOut.println("Checking copies in...");
		StdOut.println("Enter Patron ID:");
		String pid = StdIn.readString();

		StdOut.println("You entered: " + pid);

		boolean result = inController.startInTransaction(); // pStore.fetchPatron(pid);

		Patron p = inController.enterPatronForCheckIn(pid);

		StdOut.println("Checking in copies from patron: " + p);

		while (true)
		{
			StdOut.println("Enter copyID to check in, 0 to finish:");
			String copyID = StdIn.readString();
			if (copyID.equals("0"))
				break;

			Copy c = inController.enterCopyGoingIn(copyID); // how to indicate
															// copy is already
															// checked out?

			if (c != null)
			{
				StdOut.println("Checking in copy: ");
				StdOut.println(c);
			}
			else
				StdOut.println("Bad copy: reenter:");
		}

		inController.endInTransaction();

		StdOut.println("End of doCheckIn()");
	}

	private static void doDisplayPatronInfo()
	{
		StdOut.println("Enter patron ID: ");
		String pid = StdIn.readString();

		Patron p = outController.getPatronInfo(pid);
		StdOut.println(p);
	}

	private static void printMenu()
	{
		StdOut.println("Select an option:\n");
		StdOut.println("1 => Start check out transaction");
		StdOut.println("2 => Start check in transaction");
		StdOut.println("3 => Display Patron Info");
		StdOut.println("0 => Quit");
	}

	private static String getCommand()
	{
		return StdIn.readString();
	}
}


public class Stores
{

	public static Patron fetchPatron(String patronID)
	{
		return PatronStore.fetchPatron(patronID);
	}

	public static boolean addPatron(Patron p)
	{
		return PatronStore.addPatron(p);
	}

	public static Copy fetchCopy(String copyID)
	{
		return CopyStore.fetchCopy(copyID);
	}

	public static void main(String[] args)
	{
		StdOut.println(Stores.fetchCopy("001"));
		StdOut.println(Stores.fetchPatron("S000"));

	}

}

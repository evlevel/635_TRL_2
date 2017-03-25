import java.util.ArrayList;

public class Patron
{
	private String name;
	private String patronID;
	private ArrayList<Copy> copiesOut;

	public Patron(String n, String id)
	{
		this.name = n;
		this.patronID = id;
		this.copiesOut = new ArrayList<Copy>();
	}

	@Override
	public boolean equals(Object p)
	{
		if (!(p instanceof Patron))
			return false;

		Patron p2 = (Patron) p;

		if (this.patronID.equals(p2.patronID))
			return true;
		else
			return false;
	}

	public String getPatronId()
	{
		return this.patronID;
	}

	public ArrayList<Copy> getCopiesOut()
	{
		return this.copiesOut;
	}

	public boolean checkCopyOut(Copy c)
	{
		c.setOutTo(this);
		copiesOut.add(c);
		return true;
	}

	public boolean checkCopyIn(Copy c)
	{
		c.setOutTo(null);
		if (copiesOut.contains(c))
		{
			copiesOut.remove(c);
			return true;
		}
		else
			return false;
	}

	public String toString()
	{
		String toReturn = "Patron w/ name: " + this.name + ", id: " + this.patronID;

		if (this.copiesOut.isEmpty())
		{
			toReturn = toReturn + "\nNo copies checked out.\n";
		}
		else
			for (Copy copy : this.copiesOut)
			{
				toReturn = toReturn + "\nCopies checked out:";
				toReturn = toReturn + "\n\t" + copy.toString() + "\n";
			}

		return toReturn;
	}

	public static void main(String[] args)
	{
		Patron p1 = new Patron("James", "007");

		System.out.println(p1);

		String s = "foo";

		StdOut.println(p1.equals(s));

	}

}

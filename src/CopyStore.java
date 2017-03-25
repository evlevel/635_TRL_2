import java.util.HashMap;

public class CopyStore
{
	private static HashMap<String, Copy> copies;

	static
	{
		copies = new HashMap<String, Copy>();

		// load sample Copy records
		copies.put("001", new Copy("001"));
		copies.put("002", new Copy("002"));
		copies.put("003", new Copy("003"));
		copies.put("004", new Copy("004"));

	}

	public static Copy fetchCopy(String copyID)
	{

		return copies.get(copyID); // null if no such copy
	}

}

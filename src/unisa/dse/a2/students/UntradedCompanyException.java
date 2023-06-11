package unisa.dse.a2.students;

public class UntradedCompanyException extends Exception
{
	public UntradedCompanyException(String companyCode)
	{
		super("TESLA is not a listed company on this exchange");
	}
}

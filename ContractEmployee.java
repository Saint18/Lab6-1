
 1
 2
 3
 4
 5
 6
 7
 8
 9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class represents an employee who works on a term-limited contract
 * with the organization. Contract employees cannot manage
 * other employees within this organization.
 */
public class ContractEmployee extends NonManagerEmployee {
  private LocalDate contractEndDate;

  public ContractEmployee(String name, double pay, Gender gender, int date, int
   month, int year) throws IllegalArgumentException{
    super(name, pay, gender);
    //validate our date
    try {
      contractEndDate = LocalDate.of(year, month, date);
    }
    catch (DateTimeException e) {
      throw new IllegalArgumentException("Invalid contract end date");
    }
  }

  @Override
  public String getEmploymentEndDate() {
    return DateTimeFormatter.ofPattern("MMddyyyy").format(contractEndDate);
  }
  
  public void printEmployees()
  {
	  System.out.print("CONTRACTOR ");
	  super.printEmployees();
	  
  }
}

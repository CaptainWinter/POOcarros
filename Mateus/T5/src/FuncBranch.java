import java.io.*;
import java.util.ArrayList;

public class FuncBranch {

	public static void insertBranch(ArrayList<Branch> branches, String branchName) {
		Branch branch = new Branch(branchName);
		branches.add(branch);		
		updateFile(branches);
	}
	
	public static void updateFile(ArrayList<Branch> branches) {
		try (ObjectOutputStream os = new ObjectOutputStream(
				new FileOutputStream("C:\\Users\\mateu\\OneDrive\\Ambiente de Trabalho\\branches.dat"))) { // Alterar a dir para testar
			os.writeObject(branches);
			os.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

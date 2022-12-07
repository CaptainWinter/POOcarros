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
<<<<<<< Updated upstream
				new FileOutputStream("C:\\Users\\mateu\\OneDrive\\Ambiente de Trabalho\\branches.dat"))) {
=======
				new FileOutputStream("C:\\Users\\User\\Desktop\\branches.dat"))) { // Alterar a dir para testar
>>>>>>> Stashed changes
			os.writeObject(branches);
			os.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

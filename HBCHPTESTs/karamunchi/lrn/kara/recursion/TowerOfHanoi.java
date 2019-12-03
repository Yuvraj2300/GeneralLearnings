package lrn.kara.recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		solveTowersOfHanoi(5, 'A', 'B', 'C');
	}
	
	synchronized public static void solveTowersOfHanoi(int disks, char fromPeg, char toPeg, char auxPeg) {
		if (disks == 1) {
			
			System.out.println("Moving disk 1 from " + fromPeg + " to " + toPeg);
			return;
		}
		
		//Move top n-1 disks from 'A' to 'B' using 'C' as aux
		solveTowersOfHanoi(disks-1, fromPeg, auxPeg, toPeg);
		
		System.out.println("Moving Disk "+ disks +" from "+fromPeg+" to "+toPeg);
		
		//Move n-1 disks from B to C using A as aux
 		solveTowersOfHanoi(disks-1, auxPeg, toPeg, fromPeg);
	}
}

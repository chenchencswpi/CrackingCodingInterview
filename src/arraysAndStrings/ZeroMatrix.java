package arraysAndStrings;

/**
 * Write an algorithm such that if an element in an M*N matrix is 0, its entire row and column are set to 0.
 * @author Chen
 *
 */
public class ZeroMatrix {

}

class ZeroMatrixSolution {
	/**
	 * Use extra 2 arrays to keep track if the array should be set to zero.
	 * @param array
	 */
	static void zeroMatrixWithDS(int[][] array) {
		int rowCount = array.length, columnCount = array[0].length;
		boolean[] rows = new boolean[rowCount], columns = new boolean[columnCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				if (array[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}
		//zero the rows
		for (int i = 0; i < rowCount; i++) {
			if (rows[i]) {
				zeroTheRow(array, i);
			}
		}
		//zero the columns
		for (int i = 0; i < columnCount; i++) {
			if (columns[i]) {
				zeroTheColumn(array, i);
			}
		}
	}
	
	private static void zeroTheRow(int[][] array, int rowNumber) {
		for (int i = 0; i < array[0].length; i++) {
			array[rowNumber][i] = 0;
		}
	}
	
	private static void zeroTheColumn(int[][] array, int columnNumber) {
		for (int i = 0; i < array.length; i++) {
			array[i][columnNumber] = 0;
		}
	}
	
	/**
	 * Implement this method without using extra memory.
	 * @param array
	 */
	static void zeroMatrixWithoutDS(int[][] array) {
		boolean setFirstRow = false;
		boolean setFirstColumn = false;
		
		int rowCount = array.length;
		int columnCount = array[0].length;
		
		for (int i = 0; i < columnCount; i++) {
			if (array[0][i] == 0) {
				setFirstRow = true;
				break;
			}
		}
		
		for (int i = 0; i < rowCount; i++) {
			if (array[i][0] == 0) {
				setFirstColumn = true;
				break;
			}
		}
		
		for (int i = 1; i < rowCount; i++) {
			for (int j = 1; j < columnCount; j++) {
				if (array[rowCount][columnCount] == 0) {
					array[i][0] = 0;
					array[0][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < columnCount; i++) {
			if (array[0][i] == 0) {
				zeroTheColumn(array, i);
			}
		}
		
		for (int i = 0; i < rowCount; i++) {
			if (array[i][0] == 0) {
				zeroTheRow(array, i);
			}
		}
		
		if (setFirstRow) {
			zeroTheRow(array, 0);
		}
		
		if (setFirstColumn) {
			zeroTheColumn(array, 0);
		}
	}
}
package rep1;

public class GoL{

	private short[][] matrix;
	private short[][] subMatrix;

	private int size = 80;

	GoL(){
		matrix = new short[size][size];
		subMatrix = new short[size][size];
		resetMatrix();
	}

	public void resetMatrix(){

		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(Math.random()>0.7) {
					matrix[i][j]=1;
				}else {
					matrix[i][j]=0;
				}
			}
		}
		bufferingMatrix();
	}

	public void calNewMatrix(){
		bufferingMatrix();

		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				writeMatrix(i,j);
			}
		}

		applyingSubMatrix();

	}

	public void writeMatrix(int i,int j){
		subMatrix[i][j] = 0;
		int sum = getMatrixSum(i,j);
		if(matrix[i][j]==1) {
			if(sum==2||sum==3) {
				subMatrix[i][j] = 1;
			}
		}else {
			if(sum==3) {
				subMatrix[i][j] = 1;
			}
		}

	}

	public int getMatrixSum(int i,int j){
		if(i==0||j==0||i==size-1||j==size-1) {
			return 0;
		}
		int k=0;
		for(int n=-1;n<2;n++){
			for(int m=-1;m<2;m++){
				int tmpx = (size+i+n)%size;
				int tmpy = (size+j+m)%size;
				k += matrix[tmpx][tmpy];
			}
		}
		k -= matrix[i][j];
		return k;
	}

	public short[][] getMatrix() {
		return matrix;
	}

	public int getSize() {
		return size;
	}

	public void bufferingMatrix() {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				subMatrix[i][j] = matrix[i][j];
			}
		}
	}

	public void applyingSubMatrix() {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				matrix[i][j] = subMatrix[i][j];
			}
		}
	}

	public void cellClicked(int i,int j) {
		if(matrix[i][j]==1) {
			matrix[i][j]=0;
		}else {
			matrix[i][j]=1;
		}
	}
}
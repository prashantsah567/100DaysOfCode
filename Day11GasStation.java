public class Day11GasStation {
    public static void main(String[] args){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.print(canCompleteCircuit(gas, cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int pos =0, tempSum = 0, totalSum =0;

        for(int i =0;i< gas.length;i++){
            tempSum += gas[i] - cost[i];
            
            if(tempSum < 0){
                totalSum += tempSum;
                tempSum = 0;
                pos = i + 1;
            }
        }
        //the last value added to the totalSum
        totalSum += tempSum;
        //if total sum is less than 0 we can never make a circle
        return totalSum>=0 ? pos : -1;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] time = new double[n];
        Car[] cars = new Car[n];
       for (int i=0;i<n;i++) {
        cars[i] = new Car(position[i], (double)(target-position[i])/speed[i]);
       }

        Arrays.sort(cars, (a, b) -> a.position - b.position);

        int res = 1, t = n-1;
        while (t > 0) {
            if (cars[t].time < cars[t-1].time) res++;
            else {
                cars[t-1] = cars[t];
            }
            t--;
        }

        return res;
        
    }
}

class Car {
    int position;
    //int speed;
    double time;

    Car(int position, double time) {
        this.position = position;        
        this.time = time;
    }
}
import java.util.ArrayList;

public class liang_lab13
    {
	    public final ArrayList<Integer> intList;
	    
	    liang_lab13()
	    {
	        intList = new ArrayList<>();
	    }
	    
        public void readData(String filename)
        {
            try
            {
                java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
                String inn;
                while( (inn = input.readLine()) != null )
                {
                    int x = Integer.valueOf(inn);
                    intList.add(x);
                }
                input.close();
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
                System.exit(0);
            }
        }
        
        public long getTotalCount()
        {
            return intList.stream().count();
        }
        public long getOddCount()
        {   
            return intList.stream().filter(num -> num % 2 != 0).count();
        }
        public long getEvenCount()
        {
            return intList.stream().filter(num -> num % 2 == 0).count();
        }
        public long getDistinctGreaterThanFiveCount()
        {
            return intList.stream().distinct().filter(num -> num > 5).count();
        }
        public Integer[] getResult1()
        {
            return intList.stream().filter(num -> num % 2 == 0 && num > 5 && num < 50).sorted().toArray(Integer[]::new);
        }
        public Integer[] getResult2()
        {
            return intList.stream().map(num -> (num*num)*3).limit(50).toArray(Integer[]::new);
        }
        public Integer[] getResults3()
        {
            return intList.stream().filter(num -> num % 2 != 0).map(num -> (num * 2)).sorted().skip(20).distinct().toArray(Integer[]::new);
        }
    }
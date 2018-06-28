using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _7b_Array_List
{
    class Program
    {
        static void Main(string[] args)
        {
            // IMHO IT'S BAD PRACTICE TO DO THIS
            ArrayList list = new ArrayList();
            list.Add("Rover");
            list.Add(26.2);
            list.Add('c');

            Console.WriteLine(list[0]);
            Console.WriteLine(list[1]);
            Console.WriteLine(list[2]);

            // THIS IS OK
            ArrayList list2 = new ArrayList();
            list2.Add(26.3);
            list2.Add(18.22);
            list2.Add(1.4);

            double[] my_array = (double[])list2.ToArray(typeof(double));
            Console.WriteLine(my_array[0]);
            Console.WriteLine(my_array[1]);
            Console.WriteLine(my_array[2]);
        }
    }
}

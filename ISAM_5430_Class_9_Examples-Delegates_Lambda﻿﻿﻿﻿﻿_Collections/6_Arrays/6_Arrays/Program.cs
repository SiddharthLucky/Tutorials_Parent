using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _6_Arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array1 = new int[] { 1,2,4,6,7,10};

            foreach(int a in array1)
            {
                Console.Write(a + " ");
            }
            Console.WriteLine();

            for(int i=0; i<array1.Length; ++i)
            {
                Console.Write(array1[i] + " ");
            }
            Console.WriteLine();
        }
    }
}

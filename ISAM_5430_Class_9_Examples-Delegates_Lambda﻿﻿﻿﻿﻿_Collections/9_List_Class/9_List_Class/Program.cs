using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _9_List_Class
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> temperatures = new List<int>();
            temperatures.Add(72);
            temperatures.Add(70);
            temperatures.Add(74);
            temperatures.Add(71);
            temperatures.Add(74);
            temperatures.Add(68);
            temperatures.Add(71);

            foreach(int temp in temperatures)
            {
                Console.WriteLine("The temperature is {0}", temp);
            }

            // FINDS THE FIRST INSTANCE OF 74
            int index = temperatures.IndexOf(74);
            Console.WriteLine(index);
            temperatures.RemoveAt(index);

//            temperatures.LastIndexOf(71)

        }
    }
}

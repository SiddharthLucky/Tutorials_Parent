using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5_Extension_Method_without_Lambda
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> items = new List<int>();
            items.AddRange(new int[] { 2, 0, 4, 5, 4, 54, 83, 61, 15, 29 });

            Predicate<int> callback = new Predicate<int>(IsEvenNumber);
            List<int> even_numbers = items.FindAll(callback);

            foreach (int i in even_numbers)
            {
                Console.Write(i + " ");
            }
            Console.WriteLine();
        }

        static bool IsEvenNumber(int i)
        {
            return (i % 2 == 0);
        }
    }
}

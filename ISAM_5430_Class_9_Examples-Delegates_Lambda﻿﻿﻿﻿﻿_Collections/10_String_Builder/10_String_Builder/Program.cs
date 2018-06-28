using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10_String_Builder
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder names = new StringBuilder();
            names.Append("Jill ");
            names.Append("Jane ");
            names.Append("Joe ");
            names.Append("Jack");

            names.Replace("Jill", "Spot");

            string my_names = names.ToString();
            Console.WriteLine(my_names);

            // \n = newline character
            StringBuilder s = new StringBuilder();
            s.Append("Jill"+Environment.NewLine);
            s.Append("Jane" + Environment.NewLine);
            s.Append("Jane\n");
            s.Append("Jane\n");
            s.Append("Joe");

            string new_names = s.ToString();

            Console.WriteLine(new_names);

        }
    }
}

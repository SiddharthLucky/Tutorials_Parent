using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _7_Array_List
{
    class Program
    {
        static void Main(string[] args)
        {
            ArrayList people = new ArrayList();

            people.Add("Joe");
            people.Add("Jane");
            people.Add("Jill");
            people.Add("Spot");
            people.Add("Rover");

            foreach (string s in people)
            {
                Console.WriteLine(s);
            }

            int index = people.IndexOf("Fluffy");
            Console.WriteLine(index);

            index = people.IndexOf("Jane");
            Console.WriteLine(index);
            if(index >= 0)
            {
                people.RemoveAt(index);
            }
            foreach (string s in people)
            {
                Console.WriteLine(s);
            }

            index = people.IndexOf("Jill");
            Console.WriteLine(index);
            if (index >= 0)
            {
                people.Insert(index, "Jack");
            }
            foreach (string s in people)
            {
                Console.WriteLine(s);
            }

            Console.WriteLine();
            people.Sort();
            foreach (string s in people)
            {
                Console.WriteLine(s);
            }

            for(int i = 0; i< people.Count; ++i)
            {
                Console.WriteLine(people[i]);
            }

        }
    }
}

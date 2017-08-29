using HotelReservation.Model;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.UI.WebControls;

namespace HotelReservation.Contracts.Data
{
    public class DataContext : DbContext
    {
        public DataContext()
            : base("DefaultConnection")
        {
        }

        /// <summary>
        /// Declare the corresponding tables defined in HotelReservation Model
        /// </summary>
        public DbSet<Hotel> Hotels { get; set; }
        public DbSet<Book> Orders { get; set; }
        public DbSet<BookHotel> OrderItems { get; set; }
        public DbSet<Customer> Customers { get; set; }

    }
}

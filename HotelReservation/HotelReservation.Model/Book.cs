using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HotelReservation.Model
{
    public class Book
    {
        public int BookId { get; set; }

        public DateTime BookDate { get; set; }

        public int CustomerId { get; set; }

        public ICollection<BookHotel> BookHotels { get; set; }
    }
}

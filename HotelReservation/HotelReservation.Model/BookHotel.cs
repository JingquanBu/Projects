using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HotelReservation.Model
{
    public class BookHotel
    {
        public int BookHotelId { get; set; }

        public int HotelId { get; set; }

        public string Details { get; set; }

        public string HotelImageUrl { get; set; }

        public int Number { get; set; }

        public decimal Price { get; set; }
    }
}

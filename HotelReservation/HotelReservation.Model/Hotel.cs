using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HotelReservation.Model
{
    public class Hotel
    {
        /// <summary>
        /// HotelId is the key of the hotel in this framework
        /// </summary>
        public int HotelId { get; set; }

        public string Details { get; set; }

        public string HotelImageUrl { get; set; }

        public decimal Price { get; set; }

        public string Location  { get; set; }

        public string Review { get; set; }
    }
}

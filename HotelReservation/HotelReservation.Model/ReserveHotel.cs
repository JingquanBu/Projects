using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HotelReservation.Model
{
    public class ReserveHotel
    {
        public int ReserveHotelId { get; set; }
        public Guid ReserveId { get; set; }
        public int HotelId { get; set; }
        public int Number { get; set; }

        public virtual Hotel Hotel { get; set; }
    }
}

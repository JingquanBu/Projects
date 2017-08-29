using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HotelReservation.Model
{
    public class Reserve
    {
        public Guid ReserveId { get; set; }
        public DateTime date { get; set; }

        public Reserve()
        {
            this.ReserveHotels = new List<ReserveHotel>();
        }

        public virtual ICollection<ReserveHotel> ReserveHotels { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HotelReservation.Contracts.Data;
using HotelReservation.Model;

namespace HotelReservation.Contracts.Repositories
{
    public class HotelRepository : RepositoryBase<Hotel>
    {
        public HotelRepository(DataContext context)
            : base(context)
        {
            if (context == null)
                throw new ArgumentNullException();
        }
    }
}
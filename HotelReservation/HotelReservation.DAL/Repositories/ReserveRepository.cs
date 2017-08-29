using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HotelReservation.Contracts.Data;
using HotelReservation.Contracts.Repositories;

namespace HotelReservation.DAL.Repositories
{
    public class ReserveRepository : RepositoryBase<Reserve>
    {
        public ReserveRepository(DataContext context)
            : base(context)
        {
            if (context == null)
                throw new ArgumentNullException();
        }
    }
}

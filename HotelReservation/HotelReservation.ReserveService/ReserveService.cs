using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using HotelReservation.Contracts.Repositories;
using HotelReservation.Model;

namespace HotelReservation.ReserveService
{
    public class ReserveService
    {
        IRepositoryBase<Reserve> reserves;

        public const string ReserveSessionName = "HotelReserve";

        public ReserveService(IRepositoryBase<Reserve> reserves)
        {
            this.reserves = reserves;
        }

        private Reserve createNewReserve(HttpContextBase httpContext)
        {
            //reserve a hotel.

            //first create a new cookie.
            HttpCookie cookie = new HttpCookie(ReserveSessionName);
            
            Reserve reserve = new Reserve();
            reserve.date = DateTime.Now;
            reserve.ReserveId = Guid.NewGuid();

            //add to database.
            reserves.Insert(reserve);
            reserves.Commit();

            //add the reserved hotel id to a cookie
            cookie.Value = reserve.ReserveId.ToString();
            cookie.Expires = DateTime.Now.AddDays(1);
            httpContext.Response.Cookies.Add(cookie);

            return reserve;
        }

        public bool AddToReserve(HttpContextBase httpContext, int hotelId, int number)
        {
            bool success = true;

            Reserve reserve = GetReserve(httpContext);
            ReserveHotel hotel = reserve.ReserveHotels.FirstOrDefault(i => i.HotelId == hotelId);

            if (hotel == null)
            {
                hotel = new ReserveHotel()
                {
                    ReserveId = reserve.ReserveId,
                    HotelId = hotelId,
                    Number = number,
                };
                reserve.ReserveHotels.Add(hotel);
            }
            else
            {
                hotel.Number = hotel.Number + number;
            }
            reserves.Commit();

            return success;
        }

        public Reserve GetReserve(HttpContextBase httpContext)
        {
            HttpCookie cookie = httpContext.Request.Cookies.Get(ReserveSessionName);
            Reserve reserve;

            Guid reserveId;

            if (cookie != null)
            {

                if (Guid.TryParse(cookie.Value, out reserveId))
                {
                    reserve = reserves.GetById(reserveId);
                }
                else
                {
                    reserve = createNewReserve(httpContext);
                }
            }
            else
            {
                reserve = createNewReserve(httpContext);
            }

            return reserve;
        }
    }
}
    


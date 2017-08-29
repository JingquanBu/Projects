using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using HotelReservation.Contracts.Data;
using HotelReservation.Contracts.Repositories;
using HotelReservation.Model;
using HotelReservation.ReserveService;

namespace HotelReservation.WebUI.Controllers
{
    public class HomeController : Controller
    {
        IRepositoryBase<Customer> customers;
        IRepositoryBase<Hotel> hotels;
        IRepositoryBase<Reserve> Reserves;
        ReserveService reserveService;

        public HomeController(IRepositoryBase<Customer> customers, IRepositoryBase<Hotel> hotels)
        {
            this.customers = customers;
            this.hotels = hotels;
            this.reserves = Reserves;
            reserveService = new HotelReservation.ReserveService(this.reserves);
        }

        public ActionResult Index()
        {
            var hotelList = hotels.GetAll();
            return View(hotelList);
        }

        public ActionResult ReserveSummary()
        {
            var model = reserveService.GetReserve(this.HttpContext);

            return View(model.ReserveItems);
        }

        public ActionResult Reserve(int id)
        {
            ReserveService.Reserve(this.HttpContext, id, 1);//always add one to the basket

            return RedirectToAction("ReserveSummary");
        }


        public ActionResult Details(int id)
        {
            var hotel = hotels.GetById(id);
            return View(hotel);
        }


        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}
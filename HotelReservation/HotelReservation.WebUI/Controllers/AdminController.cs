using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using HotelReservation.Contracts.Repositories;
using HotelReservation.Model;

namespace HotelReservation.WebUI.Controllers
{
    public class AdminController : Controller
    {
        IRepositoryBase<Customer> customers;
        IRepositoryBase<Hotel> hotels;

        public AdminController(IRepositoryBase<Customer> customers, IRepositoryBase<Hotel> hotels)
        {
            this.customers = customers;
            this.hotels = hotels;
        }
        // GET: Admin
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult HotelList()
        {
            var model = hotels.GetAll();
            return View(model);
        }

        public ActionResult CreateHotel()
        {
            var model = new Hotel();
            return View(model);
        }

        [HttpPost]
        public ActionResult CreateHotel(Hotel hotel)
        {
            hotels.Insert(hotel);
            hotels.Commit();

            return RedirectToAction("HotelList");
        }

        public ActionResult EditHotel(int id)
        {
            Hotel hotel = hotels.GetById(id);

            return View(hotel);
        }

        [HttpPost]
        public ActionResult EditHotel(Hotel hotel)
        {
            hotels.Update(hotel);
            hotels.Commit();

            return View(hotel);
        }
    }
}
using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(HotelReservation.WebUI.Startup))]
namespace HotelReservation.WebUI
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}

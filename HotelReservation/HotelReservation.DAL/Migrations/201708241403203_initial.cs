namespace HotelReservation.Contracts.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class initial : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Hotels", "Review", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Hotels", "Review");
        }
    }
}

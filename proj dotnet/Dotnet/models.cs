using System;
using System.ComponentModel.DataAnnotations;

namespace testDataModel
{
    [Serializable]
    public class Event
    {
        [Required]
        public Guid Id { get; set; }
        [Required(AllowEmptyStrings = false), StringLength(5)]
        public string DeviceId { get; set; }

        [Required]
        public int Subject { get; set; }
    }
}
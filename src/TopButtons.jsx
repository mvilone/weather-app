const TopButtons = () => {
  const cities = [
    { id: 1, title: "London" },
    { id: 2, title: "US" },
    { id: 3, title: "Korea" },
    { id: 4, title: "Asia" },
    { id: 5, title: "Mexico" },
  ];

  return (
    <div className="top-buttons">
      {cities.map((city) => (
        <button key={city.id} className="city-button">
          {city.title}
        </button>
      ))}
    </div>
  );
};

export default TopButtons;

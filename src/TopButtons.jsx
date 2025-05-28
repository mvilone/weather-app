const TopButtons = () => {
  const cities = [
    { id: 1, title: "Washington" },
    { id: 2, title: "New York" },
    { id: 3, title: "Tokyo" },
    { id: 4, title: "Paris" },
    { id: 5, title: "London" },
  ];

  return (
    <div className="top-buttons">
      {cities.map(city => (
        <button key={city.id} className="city-button">{city.title}</button>
      ))}
    </div>
  );
};

export default TopButtons;
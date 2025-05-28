const Forecast = ({ title }) => {
  return (
    <div className="forecast">
      <h3>{title}</h3>
      <div className="forecast-content">
        <div>1PM - 20°C</div>
        <div>2PM - 21°C</div>
        <div>3PM - 22°C</div>
      </div>
    </div>
  );
};

export default Forecast;
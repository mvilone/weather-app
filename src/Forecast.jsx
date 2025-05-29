export default function Forecast({ title }) {
  return (
    <div className="forecast-section">
      <h3>{title}</h3>
      <div>5:00 PM ☀️ 22°C</div>
      <div>6:00 PM 🌧️ 21°C</div>
    </div>
  );
}

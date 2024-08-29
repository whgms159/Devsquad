import style from "./styles/mypage_main.module.css";

const MypageMain = () => {
  const createStreaks = (count) => {
    return Array.from({ length: count }, (_, index) => (
      <div key={index} className={style.streak}></div>
    ));
  };

  return (
    <div className={style.profileContainer}>
      <div className={style.profileCard}>
        <div className={style.profileHeader}>
          <img
            src="https://search.pstatic.net/sunny/?src=https%3A%2F%2Fpng.pngtree.com%2Frecommend-works%2Fpng-clipart%2F20240614%2Fourlarge%2Fpngtree-chat-bubbles-talking-dialogue-quotes-png-image_12744383.png&type=a340"
            alt="Profile"
            className={style.profileImage}
          />
          <div className={style.profileInfo}>
            <h2 className={style.nickname}>김태환</h2>
            <p className={style.language}>사용 언어: Java</p>
            <div className={style.streaksContainer}>{createStreaks(30)}</div>
          </div>
          <p className={style.mannerTemperature}>15°C</p>{" "}
        </div>
      </div>
    </div>
  );
};

export default MypageMain;

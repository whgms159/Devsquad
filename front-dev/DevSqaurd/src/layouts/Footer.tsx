import styles from './styles/Footer.module.css';
const Footer = () => {
  return (
    <footer className={styles.footer}>
      <div className={styles.footerContent}>
        <p>푸터입니다잉</p>
      </div>
      <div className={styles.footerBottom}>
        <p>&copy; 2024 Dev.inc. All rights reserved.</p>
      </div>
    </footer>
  );
};

export default Footer;

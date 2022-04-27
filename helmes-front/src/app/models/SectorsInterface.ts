export interface Sector {
  value: number,
  name: string
}

export interface SectorGroup {
  disabled?: boolean;
  name: string;
  sectors: Sector[]
}
